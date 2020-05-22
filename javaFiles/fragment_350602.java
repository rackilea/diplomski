Hashtable<Client, ArrayList<Hapsira>> reservation = new Hashtable<>();
Client client = new Client();
ArrayList<Hapsira> list = new ArrayList<>();
Hapsira hapsira = new Hapsira();
list.add(hapsira);
reservation.put(client, list);

System.out.println(reservation.get(client));