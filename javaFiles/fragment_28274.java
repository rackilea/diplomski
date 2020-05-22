case 'F':
           System.out.print("\tLabel: ");
           label = userInput.nextLine();
           if (myIcosahedronList.findIcosahedron(label) != null) {
               myIcosahedronList.findIcosahedron(label); // <- here
           }
           else {
              System.out.println("\"" + label + "\" not found");
           }
           break;