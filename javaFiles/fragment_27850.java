+----------------------+----------------------------+------------------------------+
| h = 31 * h + val[i]; | h = 31 * h + value[i];     | hash = 31 * hash + value[i]; |
+----------------------+----------------------------+------------------------------+
| LINENUMBER 1471 L7   | LINENUMBER 14 L6           | LINENUMBER 13 L4             |
| BIPUSH 31            | BIPUSH 31                  | ALOAD 0                      |
| ILOAD 1              | ILOAD 1                    | BIPUSH 31                    |
| IMUL                 | IMUL                       | ALOAD 0                      |
| ALOAD 2              | ALOAD 0                    | GETFIELD String.hash : I     |
| ILOAD 3              | GETFIELD String.value : [C | IMUL                         |
| CALOAD               | ILOAD 2                    | ALOAD 0                      |
| IADD                 | CALOAD                     | GETFIELD String.value : [C   |
| ISTORE 1             | IADD                       | ILOAD 1                      |
|                      | ISTORE 1                   | CALOAD                       |
|                      |                            | IADD                         |
|                      |                            | PUTFIELD String.hash : I     |
+----------------------+----------------------------+------------------------------+