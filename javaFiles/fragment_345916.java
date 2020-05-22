reactions += {
            case KeyPressed(_, key, _, _) =>
                pressedKeys += key
                if(pressedKeys contains Key.Space){ //Do if Space
                  label.text = "Space is down"
                  if(pressedKeys contains Key.Up) //Do if Space and Up
                    label.text = "Space and Up are down"
                }else if(pressedKeys contains Key.Up)//Do if Up
                  label.text = "Up is down"