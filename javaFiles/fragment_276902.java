package hello.easymock.constructor;

import java.io.File;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({File.class})
public class ConstructorExampleTest {

    @Test
    public void testMockFile() throws Exception {

        // first, create a mock for File
        final File fileMock = EasyMock.createMock(File.class);
        EasyMock.expect(fileMock.getAbsolutePath()).andReturn("/my/fake/file/path");
        EasyMock.replay(fileMock);

        // then return the mocked object if the constructor is invoked
        Class<?>[] parameterTypes = new Class[] { String.class };
        PowerMock.expectNew(File.class, parameterTypes , EasyMock.isA(String.class)).andReturn(fileMock);
        PowerMock.replay(File.class); 

        // try constructing a real File and check if the mock kicked in
        final String mockedFilePath = new File("/real/path/for/file").getAbsolutePath();
        Assert.assertEquals("/my/fake/file/path", mockedFilePath);
    }

}