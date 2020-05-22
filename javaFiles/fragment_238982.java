// this (untested) code reads from the OS random source to create a random id
function createRandomKey($length)
{
  $buffer = mcrypt_create_iv($length, MCRYPT_DEV_URANDOM);
  $encodedBuffer = base64_encode($buffer);
  return substr($encodedBuffer, 0, $length);
}