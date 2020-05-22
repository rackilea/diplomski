require:
  - play
  - play -> googleclosure 1.2
  - provided -> mylib 1.0

repositories:
  - provided:
      type:       local
      artifact:   "${application.path}/jar/[module]-[revision].jar"
      contains:
        - provided -> *