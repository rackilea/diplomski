public static final class NodeWrapper implements Comparable<NodeWrapper> {

    private static final SimpleDateFormat DOB_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private final Element element;
    private final Date dob;
    private final String firstName;
    private final String surName;
    private final String sex;

    public NodeWrapper(final Node node) {
        this.element = (Element) node;
        try {
            this.dob = DOB_FORMAT.parse(initDateOfBirth());
        } catch (ParseException ex) {
            throw new RuntimeException("Failed to parse dob", ex);
        }
        this.firstName = initFirstName();
        this.surName = initSurnameName();
        this.sex = initSex();
    }

    private String initFirstName() {
        return getNodeValue("firstname");
    }

    private String initSurnameName() {
        return getNodeValue("surname");
    }

    private String initDateOfBirth() {
        return getNodeValue("dateofbirth");
    }

    private String initSex() {
        return getNodeValue("sex");
    }

    private String getNodeValue(final String name) {
        return element.getElementsByTagName(name).item(0).getTextContent();
    }

    public Node getNode() {
        return element;
    }

    Date getDob() {
        return dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurName() {
        return surName;
    }

    public String getDateOfBirth() {
        return DOB_FORMAT.format(dob);
    }

    public String getSex() {
        return sex;
    }

    public int compareTo(NodeWrapper o) {
        int c;
        c = getDob().compareTo(o.getDob());
        if (c != 0) {
            return c;
        }
        c = getSurName().compareTo(o.getSurName());
        if (c != 0) {
            return c;
        }
        return getFirstName().compareTo(o.getFirstName());
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.dob != null ? this.dob.hashCode() : 0);
        hash = 47 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 47 * hash + (this.surName != null ? this.surName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NodeWrapper other = (NodeWrapper) obj;
        if (this.dob != other.dob && (this.dob == null || !this.dob.equals(other.dob))) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.surName == null) ? (other.surName != null) : !this.surName.equals(other.surName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FirstName: " + getFirstName() + ". Surname: " + getSurName() + ". DOB: " + getDateOfBirth() + ". Sex: " + getSex() + ".";
    }
}