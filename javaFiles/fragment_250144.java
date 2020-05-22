<?php
// pstools.inc.php

    function PsExecute($command, $timeout = 60, $sleep = 2) {
        // First, execute the process, get the process ID
        $pid = PsExec($command);

        if( $pid === false )
            return false;

        $cur = 0;
        // Second, loop for $timeout seconds checking if process is running
        while( $cur < $timeout ) {
            sleep($sleep);
            $cur += $sleep;
            // If process is no longer running, return true;
            if( !PsExists($pid) )
                return true; // Process must have exited, success!
        }

        // If process is still running after timeout, kill the process and return false
        PsKill($pid);
        return false;
    }

    function PsExec($command) {
        exec( dirname(__FILE__). "\\psexec.exe -s -d $command  2>&1", $output);

        while( list(,$row) = each($output) ) {
            $found = stripos($row, 'with process ID ');
            if( $found )
                return substr($row, $found, strlen($row)-$found-strlen('with process ID ')-1); // chop off last character '.' from line
        }

        return false;
    }

    function PsExists($pid) {
        exec( dirname(__FILE__). "\\pslist.exe $pid 2>&1", $output);

        while( list(,$row) = each($output) ) {
            $found = stristr($row, "process $pid was not found");
            if( $found !== false )
                return false;
        }

        return true;
    }

    function PsKill($pid) {
        exec( dirname(__FILE__). "\\pskill.exe $pid", $output);
    }