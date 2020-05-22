package com.project.generator;

import ...

public class IdGenerator extends SequenceGenerator
{
    Random r = new Random();
    private Logger log = LoggerFactory.getLogger(IdGenerator.class);
    Session session;

    int attempt = 0;

    public int generate9DigitNumber()
    {
        int aNumber = (int) ((Math.random() * 900000000) + 100000000); 
        return aNumber;
    }

    @Override
    public Serializable generate(SessionImplementor sessionImplementor, Object obj)
    {
        session = (Session) sessionImplementor;
        Integer id = generateRandomIndex();
        return id;
    }

    public Integer generateRandomIndex()
    {
            for (int i = 0; i < 3; i++)
    {
        log.info("attempt: " + i);
        Integer a = generate9DigitNumber();

        log.info("index: " + String.valueOf(a));
        if (session.get(Xyz.class, a) == null)
        {
            log.info("not found this id");
            return a;
        } else
        {
            log.info("found this id");
        }
    }

    for (int i = 100000000; i < 999999999; i++)
    {
        log.info("Is id free: " + i);
        if (session.get(Xyz.class, i) == null)
        {
            log.info("id is free: " + i);
            return i;
        }
    }
        return null;
    }
}