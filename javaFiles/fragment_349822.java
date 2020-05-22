package mst.unittest.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * @author Mark Stein
 *
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserLocalServiceUtil.class)
public class LiferayAndPowerMockTest {

    @Test
    public void testIsUserFullAge() throws PortalException, SystemException, ParseException {
        //setup
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        Date D2000_01_01 = format.parse("2000_01_01");
        Date D1990_06_30 = format.parse("1990_06_30");
        User mockUserThatIsFullAge = mock(User.class);
        when(mockUserThatIsFullAge.getBirthday()).thenReturn(D1990_06_30);
        User mockUserThatIsNotFullAge = mock(User.class);
        when(mockUserThatIsNotFullAge.getBirthday()).thenReturn(D2000_01_01);

        //overwrite getUser(...) by UserLocalServiceUtil  methode so that wir get mock user-object with mocked behavior
        PowerMockito.mockStatic(UserLocalServiceUtil.class);
        when(UserLocalServiceUtil.getUser(1234567)).thenReturn(mockUserThatIsFullAge);
        when(UserLocalServiceUtil.getUser(7654321)).thenReturn(mockUserThatIsNotFullAge);

        //run
        boolean fullAge = MySecUserUtil.isUserFullAge(1234567);

        //verify
        assertTrue(fullAge);

        //run

        boolean notfullAge = MySecUserUtil.isUserFullAge(7654321);

        //verify
        assertFalse(notfullAge);
    }

}

class MySecUserUtil {

    public static boolean isUserFullAge(long userId) throws PortalException, SystemException {
        User user = UserLocalServiceUtil.getUser(userId);
        Date birthday = user.getBirthday();
        long years = (System.currentTimeMillis() - birthday.getTime()) / ((long)365*24*60*60*1000);
        return years > 18;
    }

}