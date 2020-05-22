import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.PropertyConfigurator;

import com.abc.db.ConfigInfo;
import com.abc.db.ConfigInfoExample;
import com.abc.db.client.ConfigInfoMapper;
import com.abc.db.init.DatabaseConnectivity;



class Log4jTestMyBatis {

    static Logger logger = LoggerFactory.getLogger(Log4jTestMyBatis.class)

    static main(args) {
        PropertyConfigurator.configure(Log4jTestMyBatis.class.getResource("log4j.properties"));

        DatabaseConnectivity.init()
        SqlSession newABCSession = DatabaseConnectivity.getNewABCSessionFactory().openSession()

        ConfigInfoMapper mapper = newABCSession.getMapper(ConfigInfoMapper.class)
        ConfigInfoExample qExample = new ConfigInfoExample()
        qExample.createCriteria().andProjectIdEqualTo("0-12170")
        List<ConfigInfo> ctlist = mapper.selectByExample(qExample)

        logger.debug(ctlist.get(0).getCfgName())

        newABCSession.close()
        logger.debug("debug")

    }   

}