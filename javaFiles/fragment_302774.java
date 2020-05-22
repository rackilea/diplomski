#!/bin/sh
loc=$1
name=$2
wkspace=$3
cd "$loc" || { printf 'failed to cd to %s\n' "$loc" ; exit 1; }
cp "$name" "$wkspace" || { printf 'failed to copy %s\n' "$name" ; exit 1; }