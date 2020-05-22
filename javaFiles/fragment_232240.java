@Entity
@Table(name = "common_multilingualtexts")
public class MultilingualText implements Serializable
{
    private Integer m_iKeyMultilingualText;
    private Map<String, String> m_lValues = new HashMap<String, String>();

    public void setKeyMultilingualText(Integer p_iKeyMultilingualText)
    {
        m_iKeyMultilingualText = p_iKeyMultilingualText;
    }

    @Id
    @GeneratedValue
    @Column(name = "keyMultilingualText")
    public Integer getKeyMultilingualText()
    {
        return m_iKeyMultilingualText;
    }

    public void setValues(Map<String, String> p_lValues)
    {
        m_lValues = p_lValues;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "languageCode")
    @CollectionTable(name = "common_multilingualtexts_values", joinColumns = @JoinColumn(name = "keyMultilingualText"))
    @Column(name = "value")
    public Map<String, String> getValues()
    {
        return m_lValues;
    }

    public void put(String p_sLanguageCode, String p_sValue)
    {
        m_lValues.put(p_sLanguageCode,p_sValue);
    }

    public String get(String p_sLanguageCode)
    {
        if(m_lValues.containsKey(p_sLanguageCode))
        {
            return m_lValues.get(p_sLanguageCode);
        }

        return null;
    }
}