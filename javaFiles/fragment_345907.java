class SetColor implements GenericFunction
{
    private Color m_Color;

    SetColor(Color c) { m_Color = c; }

    void do()
    {
        graphics.setColor(m_Color);
    }
}