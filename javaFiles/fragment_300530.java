result = stream.read(bytearray);
              if (result == -1)
                  break;
              processBytes(bytearray, result);
              if (Thread.interrupted()) {
                  // We've been interrupted: no more crunching.
                  // handle the interruption here by throwing an Exception or returning.. or something else
               }