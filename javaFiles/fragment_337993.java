#!/bin/sh
java Commands | while read command; do
  echo
  echo "command: $command"
  $command
done