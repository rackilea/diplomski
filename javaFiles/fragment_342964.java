package com.somecompany.productfeed;

import net.snakedoc.jutils.ConfigException;

import org.apache.log4j.Logger;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SFTP {

    // setup logger
    private static final Logger LOG = Logger.getLogger(SFTP.class.getName());

    private JSch jsch;
    private ChannelSftp sftpChannel;
    private Session session;

    private String username;
    private String password;
    private String host;
    private int port;

    // singleton
    private volatile static SFTP instance = null;

    /**
     * Private constructor used in Singleton pattern.
     *     All variables populated via properties file upon 
     *     object instantiation. Since we only need FTP to one server,
     *     object variables are immutable after instantiation.
     * 
     * @throws ConfigException
     * @throws NumberFormatException
     */
    private SFTP() throws ConfigException, NumberFormatException {

        this.jsch = new JSch();
        this.username = Config.getInstance().getConfig("SFTP_USER");
        this.password = Config.getInstance().getConfig("SFTP_PASS");
        this.host = Config.getInstance().getConfig("SFTP_HOST");
        this.port = Integer.parseInt(Config.getInstance().getConfig("SFTP_PORT"));

    }

    /**
     * Create or Return SFTP Object using Singleton pattern.
     * 
     * @return Singleton of SFTP Object.
     * @throws NumberFormatException
     * @throws ConfigException
     */
    public static SFTP getInstance() throws NumberFormatException, ConfigException {

        if (SFTP.instance == null) {

            synchronized (SFTP.class) {

                if (SFTP.instance == null) {

                    SFTP.instance = new SFTP();

                }

            }

        }

        return SFTP.instance;

    }

    /**
     * If connection is not already open/connected, open connection.
     * 
     * @throws JSchException
     */
    public void openConnection() throws JSchException {

        LOG.info("Opening SFTP Connection");
        if (null == getSession() || ! getSession().isConnected()) {

            setSession(jsch.getSession(this.username, this.host, this.port));
            getSession().setConfig("StrictHostKeyChecking", "no");
            getSession().setPassword(this.password);
            getSession().connect();

            Channel channel = getSession().openChannel("sftp");
            channel.connect();
            setSftpChannel((ChannelSftp) channel);

        } else {

            LOG.info("SFTP Connection already open");

        }

        LOG.debug("Success");

    }

    /**
     * Closes connection.
     */
    public void closeConnection() {

        LOG.info("Closing SFTP connection");
        getSftpChannel().exit();
        getSession().disconnect();
        LOG.debug("SFTP Connection closed");

    }

    /**
     * Checks if SFTP Connection is open.
     * 
     * @return TRUE if connection is open, FALSE if connection is closed
     */
    public boolean isOpen() {

        if (getSession().isConnected()) {

            return true;

        } else {

            return false;

        }

    }

    /**
     * Gets SFTP Channel
     * 
     * @return SFTP Channel (<code>ChannelSftp</code>)
     */
    private ChannelSftp getSftpChannel() {

        return this.sftpChannel;

    }

    /**
     * Returns current <code>Session</code>
     * 
     * @return <code>Session</code>
     */
    private Session getSession() {

        return this.session;

    } 

    /**
     * Sets SFTP Channel (<code>ChannelSftp</code>)
     * 
     * @param sftpChannel Channel to set this object's <code>ChannelSftp</code>
     */
    private void setSftpChannel(ChannelSftp sftpChannel) {

        this.sftpChannel = sftpChannel;

    }

    /**
     * Sets current <code>Session</code>
     * 
     * @param session Sets this object's <code>Session</code>
     */
    private void setSession(Session session) {

        this.session = session;

    }

    /**
     * Pushes local file to remote location
     * 
     * @param local String representation of filepath + filename (ex: /some_local_directory/somefile.txt)
     * @param remote String representation of filepath + filename (ex: /some_remote_directory/somefile.txt)
     * @throws SftpException
     */
    public void push(String local, String remote) throws SftpException {

        LOG.info("Sending file: " + local + " to remote: " + remote);
        getSftpChannel().put(local, remote);
        LOG.debug("Success");

    }

    /**
     * Gets remote file to local location
     * 
     * @param remote String representation of filepath + filename (ex: /some_remote_directory/somefile.txt)
     * @param local String representation of filepath + filename (ex: /some_local_directory/somefile.txt)
     * @throws SftpException
     */
    public void get(String remote, String local) throws SftpException {

        LOG.info("Retrieving file: " + remote + " saving to: " + local);
        getSftpChannel().get(remote, local);
        LOG.debug("Success");

    }

}