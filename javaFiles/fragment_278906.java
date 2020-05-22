if(clients[newClientNum].nickname.equals(clients[i].nickname));
        {
            clients[newClientNum].nickname += " (1)";
            System.out.println("New clients new nickname: " + clients[newClientNum].nickname);
            i = -1;
        }