@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "keyTitle")
public MultilingualText getTitle()
{
    return m_oTitle;
}