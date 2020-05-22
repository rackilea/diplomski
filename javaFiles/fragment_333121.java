volatile Boolean Reference;

public static Runnable createOnOffSwitchRunnable(Boolean b)
{
    Reference = b;

    Runnable R = new Runnable()
    {
        public void run()
        {
            if (Reference.booleanValue() == true)
            {
                Reference = false;
            }
        }
    };
    return R;
}