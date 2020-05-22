public class DetailBean
{
    // You should use private members, and create getters and setters to them
    public String data = null;
    public String code = null;
    public String fields = null;
    public String group_name = null;
    public String field = null;
    public String id = null;
    public String name = null;
    public String value = null;
    public String status = null;
    public String required = null;
    public String type = null;

    public DetailBean()
    {
        this("", "", "", "", "", "", "", "", "", "", "");
    }

    public DetailBean(String data, String code, String fields, 
            String group_name, String field, String id, String name,
            String value, String status, String required, String type)
    {
        this.data = data;
        this.code = code;
        this.fields = fields;
        this.group_name = group_name;
        this.field = field;
        this.id = id;
        this.name = name;
        this.value = value;
        this.status = status;
        this.required = required;
        this.type = type;
    }

    @Override
    public String toString()
    {
        // You should populate this string with the data
        // you need inside the TextView
        return this.group_name + " " + this.data;
    }
}