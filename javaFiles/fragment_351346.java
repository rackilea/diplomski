#!/bin/sh

set -e
test ":$DEBUG" != :true || set -x

# set image
set -- debian:jessie "$@"

# use current user and its groups at host
for v in /etc/group /etc/passwd; do
  [ ! -r "$v" ] || set -- -v $v:$v:ro "$@"
done
set -- --user "`id -u`:`id -g`" "$@"
for g in `id -G`; do
  set -- --group-add "$g" "$@"
done
set -- -v "$HOME":"$HOME" "$@"

exec docker run --rm -it "$@"