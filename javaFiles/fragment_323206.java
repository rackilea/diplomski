while ((message = bufferedReader.readLine()) != null) {
            System.out.println("Incomming message client : " + message);
            // is there a colon followed by a space in the message?
            final String delimiter = ": ";
            int indexOfColon = message.lastIndexOf(delimiter);
            if (indexOfColon == -1) { // no, no colon and space in message
                // try to use entire message
                k += Integer.parseInt(message);
            } else { // yes
                // take out the part after the colon and space and try parsing it as an integer
                int number = Integer.parseInt(message.substring(indexOfColon + delimiter.length()));
                k += number;
            }
            System.out.println("la somme est :" + k);
        }