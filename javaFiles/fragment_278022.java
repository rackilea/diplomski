for(String a: sentence) { 
            sb.append(a); // this will iterate the sentence array in sequential order
            sb.append(";");

            for(String b: score) {
              // this will always pick score 1 because there will be only one iteration due to break
                sb.append(b);
                sb.append('\n');
                break; // stop the loop after first iteration
            }
        }