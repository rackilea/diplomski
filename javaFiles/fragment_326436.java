stoken_json = hash_to_json({'session_id' => SecureRandom.uuid, 'ts_ms' => (Time.now.to_f * 1000).to_i})
cipher = OpenSSL::Cipher::AES128.new(:ECB)
private_key_digest = Digest::SHA1.digest(private_key)[0...16]

cipher.encrypt
cipher.key = private_key_digest
encrypted_stoken = cipher.update(stoken_json) << cipher.final
encoded_stoken = Base64.urlsafe_encode64(encrypted_stoken).gsub(/\=+\Z/, '')