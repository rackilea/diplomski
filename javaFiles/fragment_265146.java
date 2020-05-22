import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Unit {

    private Integer id;

    private Integer unitId;
    private String name;
    private Date registrationDate;

    private String service;

    private String nation;

    public Unit() {
    }

    public Unit(Integer id) {
        this.id = id;
    }

    public Unit(Integer unitId, String name, Date registrationDate, String service, String nation) {
        this.unitId = unitId;
        this.name = name;
        this.registrationDate = registrationDate;
        this.service = service;
        this.nation = nation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.game.database.entity.Unit[id=" + id + "]";
    }


    public static void main(String... args) {

        Unit unit1 = new Unit(1, "Test Unit1", new Date(), "DisService", "MyNation");
        Unit unit2 = new Unit(2, "Test Unit2", new Date(), "DisService", "TheirNation");
        Unit unit3 = new Unit(3, "Test Unit3", new Date(), "DisService", "TheirNation");

        Set unitSet = new HashSet();
        unitSet.add(unit2);
        unitSet.add(unit1);
        unitSet.add(unit3);

        System.out.println(unitSet.size());

    }