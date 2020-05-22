> Task :app:compileDebugJavaWithJavac FAILED
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:41: error: package com.payfort.start does not exist
import com.payfort.start.Card;
                        ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:42: error: package com.payfort.start does not exist
import com.payfort.start.Start;
                        ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:43: error: package com.payfort.start does not exist
import com.payfort.start.Token;
                        ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:44: error: package com.payfort.start does not exist
import com.payfort.start.TokenCallback;
                        ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:45: error: package com.payfort.start.error does not exist
import com.payfort.start.error.CardVerificationException;
                              ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:46: error: package com.payfort.start.error does not exist
import com.payfort.start.error.StartApiException;
                              ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:70: error: cannot find symbol
public class PaymentActivity extends AppCompatActivity implements TokenCallback {
                                                                  ^
  symbol: class TokenCallback
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:83: error: cannot find symbol
    private Start start = new Start(API_OPEN_KEY);
            ^
  symbol:   class Start
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:335: error: cannot find symbol
    public void checkLastFour(View view, Card card) throws CardVerificationException {
                                         ^
  symbol:   class Card
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:335: error: cannot find symbol
    public void checkLastFour(View view, Card card) throws CardVerificationException {
                                                           ^
  symbol:   class CardVerificationException
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:354: error: cannot find symbol
    public void createToken(View view, Card card) {
                                       ^
  symbol:   class Card
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:532: error: cannot find symbol
    public void createCard(final Card crd) {
                                 ^
  symbol:   class Card
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:678: error: cannot find symbol
    private Card unbindCard() throws CardVerificationException {
            ^
  symbol:   class Card
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:678: error: cannot find symbol
    private Card unbindCard() throws CardVerificationException {
                                     ^
  symbol:   class CardVerificationException
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:739: error: package Card does not exist
    private void setErrors(EnumSet<Card.Field> errors) {
                                       ^
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:760: error: cannot find symbol
    public void onSuccess(Token token) {
                          ^
  symbol:   class Token
  location: class PaymentActivity
/home/akumanotatsujin/AndroidStudioProjects/Android-Labayh/app/src/main/java/com/labayh/customer/activity/PaymentActivity.java:768: error: cannot find symbol
    public actionablevoid onError(StartApiException e) {
                        ^
  symbol:   class StartApiException
  location: class PaymentActivity
17 errors