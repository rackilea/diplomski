$components = @("COMP_Number1","COMP_Number2")
$theProcess | %{ 
    $p = $_
    $running = $components | ?{$p.commandline -match $_}
    $notrunning = $components | ?{ $running -notcontains $_ }
}

$notrunning