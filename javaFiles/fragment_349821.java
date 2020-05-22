package mst.unittest.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.liferay.portal.kernel.bean.BeanLocator;
import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

/**
 * @author mark.stein.ms@gmail.com
 */
public class MyUserUtilTest {


    private BeanLocator mockBeanLocator;

    @Before
    public void init()  {
        //create mock for BeanLocator, BeanLocator is responsible for loading of Services
        mockBeanLocator = mock(BeanLocator.class);
        //... and insert it in Liferay loading infrastructure (instead of Spring configuration)
        PortalBeanLocatorUtil.setBeanLocator(mockBeanLocator);
    }

    @Test
    public void testIsUserFullAge() throws PortalException, SystemException, ParseException {
        //setup
        SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd");
        Date D2000_01_01 = format.parse("2000_01_01");
        Date D1990_06_30 = format.parse("1990_06_30");
        UserLocalService mockUserLocalService = mock(UserLocalService.class);
        User mockUserThatIsFullAge = mock(User.class);
        when(mockUserThatIsFullAge.getBirthday()).thenReturn(D1990_06_30);
        User mockUserThatIsNotFullAge = mock(User.class);
        when(mockUserThatIsNotFullAge.getBirthday()).thenReturn(D2000_01_01);
        //overwrite getUser(...) methode so that wir get mock user-object with mocked behavior
        when(mockUserLocalService.getUser(1234567)).thenReturn(mockUserThatIsFullAge);
        when(mockUserLocalService.getUser(7654321)).thenReturn(mockUserThatIsNotFullAge);

        //load our mock-object instead of default UserLocalService
        when(mockBeanLocator.locate("com.liferay.portal.service.UserLocalService")).thenReturn(mockUserLocalService);


        //run
        User userFullAge = UserLocalServiceUtil.getUser(1234567);
        boolean fullAge = MyUserUtil.isUserFullAge(userFullAge);

        //verify
        assertTrue(fullAge);

        //run
        User userNotFullAge = UserLocalServiceUtil.getUser(7654321);
        boolean notfullAge = MyUserUtil.isUserFullAge(userNotFullAge);

        //verify
        assertFalse(notfullAge);
    }

}

class MyUserUtil {

    public static boolean isUserFullAge(User user) throws PortalException, SystemException {
        Date birthday = user.getBirthday();
        long years = (System.currentTimeMillis() - birthday.getTime()) / ((long)365*24*60*60*1000);
        return years > 18;
    }

}