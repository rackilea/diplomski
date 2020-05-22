class ExampleManager
{ 
private:
   static std::shared_ptr<Example> _example;

public:
   static std::shared_ptr<Example> getExample()
   { 
      return _example;
   }

   static void setExample(std::shared_ptr<Example> example)
   {
      _example = example;
   }
};