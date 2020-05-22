import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.EntryObject;
import com.hazelcast.query.PredicateBuilder;

import java.io.Serializable;
import java.sql.Date;

public class Test
{
    public static void main(String[] args)
    {
        HazelcastInstance hz = Hazelcast.newHazelcastInstance();

        IMap<MyObject, MyEnum> map = hz.getMap("test");

        EntryObject entryObject = new PredicateBuilder().getEntryObject();
        PredicateBuilder builder = entryObject.key().get("date").isNull();

        map.addIndex("__key#date", true);

        map.put(new MyObject(), MyEnum.TEST_ENUM);
    }

    public static class MyObject implements Serializable
    {
        private Date date;

        public Date getDate()
        {
            return date;
        }

        public void setDate(Date date)
        {
            this.date = date;
        }
    }

    public static enum MyEnum {
        TEST_ENUM;
    }
}