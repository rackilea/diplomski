public function __call($name, $args)
{
  if (method_exists($old, $name))
  {
    call_user_func([$obj, $name], $args);
  }
}