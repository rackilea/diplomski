import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.*;

public class JMSExample {

    static String serverUrl = "tcp://10.101.111.101:10001"; // values changed
    static String userName = "user";
    static String password = "pwd";

     static QueueConnection connection;
     static QueueReceiver queueReceiver;
     static Queue queue;

    static TextMessage message;

    public static void sendTopicMessage(String topicName, String messageStr) {

        Connection connection = null;
        Session session = null;
        MessageProducer msgProducer = null;
        Destination destination = null;


        try {
            TextMessage msg;

            System.out.println("Publishing to destination '" + topicName
                    + "'\n");

            ConnectionFactory factory = new com.tibco.tibjms.TibjmsConnectionFactory(
                    serverUrl);

            connection = factory.createConnection(userName, password);


            session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);



            destination = session.createQueue(topicName);


            msgProducer = session.createProducer(null);



            msg = session.createTextMessage();

            msg.setStringProperty("SourceId", userName);
            msg.setStringProperty("BusinessEvent", password);


            msg.setText(messageStr);


            msgProducer.send(destination, msg);



            System.out.println("Published message: " + messageStr);


            connection.close();

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) throws JMSException {
        // TODO Auto-generated method stub

        JMSExample.sendTopicMessage("***.***.***.**.**.Order.Management.***.1",
                "Hi");
        //System.out.println(getMessage());

    }