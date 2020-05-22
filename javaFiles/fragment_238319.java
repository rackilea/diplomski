@Column(name="skills")
public String getSkills() {
    return skills;
}

@Transient
public int getRowCount() {
    return rowCount;
}