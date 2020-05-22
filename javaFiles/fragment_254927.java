import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class OrgAddressTypeHandler extends BaseTypeHandler<OrganizationAddress> {

  @Override
  public OrganizationAddress getNullableResult(ResultSet rs, String colName) throws SQLException {
    OrganizationAddress oa = new OrganizationAddress();
    oa.setState(rs.getString(colName));
    return oa;
  }

  @Override
  public OrganizationAddress getNullableResult(ResultSet rs, int colNum) throws SQLException {
    OrganizationAddress oa = new OrganizationAddress();
    oa.setState(rs.getString(colNum));
    return oa;
  }

  @Override
  public OrganizationAddress getNullableResult(CallableStatement cs, int colNum) throws SQLException {
    OrganizationAddress oa = new OrganizationAddress();
    oa.setState(cs.getString(colNum));
    return oa;
  }

  @Override
  public void setNonNullParameter(PreparedStatement arg0, int arg1, OrganizationAddress arg2, JdbcType arg3) throws SQLException {
    // not needed for this example
  }
}