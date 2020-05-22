public static Runnable createOnOffSwitchRunnable(final Boolean b)
{

    Runnable R = new Runnable()
    {
        private Boolean Reference = b;

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