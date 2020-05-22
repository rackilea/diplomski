public void critReactRoomStateChange(String command, PC pc, String name) {
    List<Creature> creatures = getCreatures();
    for (Creature c : creatures) {
        if (!(c instanceof PC) && !(c.getName().equals(name))) {
                c.reactStateChange(command, pc);
                c.checkNewRoom();
//                    if (!temp.equals(c)) {
//                        i--;
//                    }
        }
    }
}