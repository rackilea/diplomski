package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Table {

    private final SimpleIntegerProperty bPlayerID;
    private final SimpleStringProperty bLeague;
    private final SimpleStringProperty bName;

    public Table(int cPlayerID, String cLeague, String cName) {
        this.bPlayerID = new SimpleIntegerProperty(cPlayerID);
        this.bLeague = new SimpleStringProperty(cLeague);
        this.bName = new SimpleStringProperty(cName);
    }

    public int getBPlayerID() {
        return bPlayerID.get();
    }
    public void setBPlayerID(int v) {
        bPlayerID.set(v);
    }
    public String getBLeague() {
        return bLeague.get();
    }
    public void setBLeague(String v) {
        bLeague.set(v);
    }
    public String getBName() {
        return bName.get();
    }
    public void setBName(String v) {
        bName.set(v);
    }
}