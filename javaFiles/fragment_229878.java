package assignment7;

import java.util.ArrayList;
import java.util.List;


class Node {

    public long cid;
    public ArrayList<String> Satellite;
    public Node l;
    public Node r;

    public Node(long cid, ArrayList<String> Sat) {

    this.Satellite = new ArrayList<String>(Sat.subList(0, Math.min(9, Sat.size())));
    this.cid = cid;


    }

}