class Tuple
{
    private:
        // ...
        int _id;
        std::string _stream;
    public:
        // ...
        bool is_heartbeat_tuple()
        {
            if (this->_id == -1 && this->_stream.compare("__heartbeat") == 0)
                return true;
            return false;
        }
}
class Bolt
{
    public:
        // ...
        void Run()
        {
            Mode = BOLT;
            std::pair<Json::Value, Json::Value> conf_context = InitComponent();
            Initialize(conf_context.first, conf_context.second);
            while(1)
            {
                Tuple tuple = ReadTuple();
                Anchor_tuple = &tuple;
                if (tuple.is_heartbeat_tuple())
                    sync();
                else
                {
                    Process(tuple);
                    Ack(tuple.GetID());
                }
            }
        }
}