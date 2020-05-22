for (int i = 0; i < 20; i++)
{
    int R = (int) (Math.random()*256);
    int G = (int) (Math.random()*256);
    int B = (int) (Math.random()*256);
    Color color = new Color(R, G, B);

    JButton button = new JButton(Integer.toString(i));
    setBackground(color);
    add(button);
}