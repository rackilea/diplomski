package com.your.package.hibernate.types;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.joda.time.DurationFieldType;
import org.joda.time.Period;
import org.joda.time.ReadableDuration;
import org.joda.time.ReadablePeriod;
import org.postgresql.util.PGInterval;

public class JodaTimeDurationType
    implements UserType {

    public Class<?> returnedClass() {
        return ReadableDuration.class;
    }


    public int[] sqlTypes() {
        return new int[] {Types.OTHER};
    }


    public Object nullSafeGet(ResultSet resultSet, String[] names, Object owner)
        throws HibernateException, SQLException {

        try {
            final PGInterval pgi = (PGInterval)resultSet.getObject(names[0]);

            final int years = pgi.getYears();
            final int months = pgi.getMonths();
            final int days = pgi.getDays();
            final int hours = pgi.getHours();
            final int mins = pgi.getMinutes();
            final double secs = pgi.getSeconds();

            return new Period(years, months, 0, days, hours, mins, (int)secs, 0).toStandardDuration();

        }
        catch (Exception e) {
            return null;
        }
    }


    public void nullSafeSet(PreparedStatement statement, Object value, int index)
        throws HibernateException, SQLException {

        if (value == null) {
            statement.setNull(index, Types.OTHER);
        }
        else {
            final ReadablePeriod period = ((ReadableDuration)value).toPeriod();

            final int years = period.get(DurationFieldType.years());
            final int months = period.get(DurationFieldType.months());
            final int days = period.get(DurationFieldType.days());
            final int hours = period.get(DurationFieldType.hours());
            final int mins = period.get(DurationFieldType.minutes());
            final int secs = period.get(DurationFieldType.seconds());

            final PGInterval pgi = new PGInterval(years, months, days, hours, mins, secs);
            statement.setObject(index, pgi);
        }
    }


    public boolean equals(Object x, Object y)
        throws HibernateException {

        return x == y;
    }


    public int hashCode(Object x)
        throws HibernateException {
        return x.hashCode();
    }


    public Object deepCopy(Object value)
        throws HibernateException {
        return value;
    }


    public boolean isMutable() {
        return false;
    }


    public Serializable disassemble(Object value)
        throws HibernateException {
        throw new HibernateException("not implemented");
    }


    public Object assemble(Serializable cached, Object owner)
        throws HibernateException {
        throw new HibernateException("not implemented");
    }


    public Object replace(Object original, Object target, Object owner)
        throws HibernateException {
        throw new HibernateException("not implemented");
    }
}