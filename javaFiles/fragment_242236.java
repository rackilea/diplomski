package application;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Table {

    private final IntegerProperty bPlayerID;
    private final StringProperty bLeague;
    private final StringProperty bName;

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
    public IntegerProperty bPlayerIDProperty() {
        return bPlayerID ;
    }

    public String getBLeague() {
        return bLeague.get();
    }
    public void setBLeague(String v) {
        bLeague.set(v);
    }
    public StringProperty bLeagueProperty() {
        return bLeague ;
    }

    public String getBName() {
        return bName.get();
    }
    public void setBName(String v) {
        bName.set(v);
    }
    public StringProperty bNameProperty() {
        return bName ;
    }
}