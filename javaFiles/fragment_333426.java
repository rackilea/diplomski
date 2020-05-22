struct ReadParameters 
{
     double MaxAge;
     OpcUa::TimestampsToReturn TimestampsToReturn;
     std::vector<OpcUa::ReadValueId> AttributesToRead;

     ReadParameters();
};
struct ReadValueId 
{
     OpcUa::NodeId NodeId;
     OpcUa::AttributeId AttributeId;
     std::string IndexRange;
     OpcUa::QualifiedName DataEncoding;
};