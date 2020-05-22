public class Enemy1 extends NPC {
}
public class Enemy2 extends NPC {
}

public class NPCFactory {
    public static NPC makeNPC(int npcType) {
        if(npcType==1){ return new Enemy1(); }
        elif(npcType==2) {return new Enemy2(); }
    }
}