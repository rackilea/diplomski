#!/bin/sh

#  Get the directory of this script being run
SCRIPT_PATH="`dirname ${BASH_SOURCE[0]}`"

# Export the Path
export DYLD_LIBRARY_PATH=$SCRIPT_PATH/lib:$DYLD_LIBRARY_PATH

#  Run the executable
$SCRIPT_PATH/bin/foo