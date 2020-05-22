String romaji = roma.nextLine().toLowerCase();

while (true) {
    if (table.containsKey(romaji)) {
        System.out.println(table.get(romaji));
        break;
    }
    else {   
        System.out.println("Enter a valid char:";
        romaji = roma.nextLine().toLowerCase();
    }
}
roma.close();