#!/usr/bin/env scala
for( arg <- args.toList ::: cpArgs ){
  printf("[%s]\n",arg)
}

lazy val cpArgs = System.getenv("CP_ARGS") match {
  case null => Nil
  case text => text.split("[;|]+").toList
}