void EchoClient::onTextMessageReceived(QString message)
{
    if (!m_debug)
        qDebug() << "Message received:" << message;

    setData(message); //setting atribute message
}