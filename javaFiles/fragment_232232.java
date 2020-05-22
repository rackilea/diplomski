import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
public class SignUpPresenterTest {

    public interface SignUpContract {

        interface view {
            void showSignInScreen();
            void onError(int code, String message);
        }

        interface model {

            interface onFinish<R> {
                void onResponse(R data);
                void onError(String error);
            }

            void trySignIn(onFinish onFinish, String name, String password);
        }

        interface presenter {
            void handleSignInButtonClick(String username, String password);
        }
    }

    public static class SignUpPresenter implements SignUpContract.presenter, SignUpContract.model.onFinish {

        SignUpContract.view view;
        SignUpContract.model model;

        public SignUpPresenter(SignUpContract.view view, SignUpContract.model model) {
            this.view = view;
            this.model = model;
        }

        @Override
        public void handleSignInButtonClick(String username, String password) {
            try {
                model.trySignIn(this, username, password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onResponse(Object data) {
            view.showSignInScreen();
        }

        @Override
        public void onError(String error) {
            view.onError(1, error);
        }
    }

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    @Mock
    SignUpContract.model model;

    @Mock
    SignUpContract.view view;

    SignUpPresenter SUT;

    @BeforeEach
    public void setUp() throws Exception {
        SUT = new SignUpPresenter(view, model);
    }

    @Test
    public void try_signin_success() throws Exception {

        Mockito.doAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Object[] args = invocation.getArguments();
                SignUpContract.model.onFinish callback = (SignUpContract.model.onFinish) args[0];
                callback.onResponse(0);
                return null;
            }
        }).when(model).trySignIn(Mockito.any(SignUpContract.model.onFinish.class), Mockito.eq(USERNAME), Mockito.eq(PASSWORD));

        ArgumentCaptor<String> ac = ArgumentCaptor.forClass(String.class);

        SUT.handleSignInButtonClick(USERNAME, PASSWORD);

        Mockito.verify(model, Mockito.times(1)).trySignIn(Mockito.any(SignUpContract.model.onFinish.class), ac.capture(), ac.capture());

        List<String> captures = ac.getAllValues();

        Assert.assertEquals(USERNAME, captures.get(0));
        Assert.assertEquals(PASSWORD, captures.get(1));

        Mockito.verify(view).showSignInScreen();
    }
}