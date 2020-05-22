#! /bin/bash
# Assumptions:
# Process is attached to a tty.
#

[[ -z "$1" ]] && echo "Usage: $0 pid" && exit 1

[[ "$1" != +([0-9]) ]] && echo "$1 is not a valid pid" && exit 1

PID="$1"
W=$(which w)
PS=$(which ps)
SED=$(which sed)
AWK=$(which awk)
TTY=$($PS -o tty4 $PID)
TTNo=$(echo "$TTY" | $SED -e '/TTY/d')

TIME=$($W | $SED -n -e "/pts\/$TTNo/p" |  $AWK '{ print $5 }')

echo $PID has been idle for $TIME