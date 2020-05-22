private UUID id;

@Id
@Column(name="id")
public String getId()
{
    return id.toString();
}

public void setId(String value)
{
    id = UUID.fromString(value);
}

public UUID idAsUUID()
{
    return id;
}