#!/bin/bash
export CP_ARGS="$@"
exec $(which scala) "$0"
!#
// vim: ft=scala

for( arg <- cpArgs ){
  printf("[%s]\n",arg)
}

lazy val cpArgs = System.getenv("CP_ARGS") match {
  case null => Nil
  case text => text.split("[;|]+").toList
}