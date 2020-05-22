System.out.print("Enter Friend's name to remove: ");
            name = input.next();

            //                  friendsList.remove(name);
            System.out.println("Trying to locate <" + name + ">");
            for (int i = friendsList.size() - 1; i >= 0; --i) {
                final Friends f = friendsList.get(i);
                System.out.println("\tChecking with <" + friendsList.get(i).name + ">");
                if (f.name.equals(name)) {
                    System.out.println("Found that bitch at index " + i);
                    friendsList.remove(i);
                    System.out.println("... and kicked him out");
                }
            }

            break;